import React, { useEffect, useState } from "react";
import axios from "axios";
import xmljs from "xml-js";

const StockList = () => {
  const [stocks, setStocks] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchStockData = async () => {
      try {
        const response = await axios.get("/auth/token", {
          params: {
            serviceKey: "kRbf3pPYuZRTZkVi6yG0Ee6zs88UgEpCBqIKc0qCdo5Nbl3XnpGekFsUykdd/pSH2PUu7xZZgHfSj0RWcbbVRA=="
          },
          timeout: 30000



        });

        debugger;

        const jsonData = xmljs.xml2js(response.data, { compact: true, spaces: 2 });
        console.log("JSON 변환 결과:", jsonData);

        const authMsg = jsonData?.OpenAPI_ServiceResponse?.cmmMsgHeader?.returnAuthMsg?._text;
        if (authMsg) {
          throw new Error(authMsg);
        }

        const items = jsonData?.response?.body?.items?.item;
        setStocks(Array.isArray(items) ? items : [items]);
      } catch (err) {
        if (err.code === "ECONNABORTED") {
          console.error("⏳ 요청 타임아웃 발생 (10초 초과):", err);
          setError("서버 응답이 너무 느립니다. 나중에 다시 시도하세요.");
        } else {
          console.error("🚨 API 호출 오류:", err);
          setError(err.message || "데이터를 불러오는 중 오류가 발생했습니다.");
        }
      }
    };

    fetchStockData();
  }, []);

  return (
      <div>
        <h1>📈 실시간 주식 정보</h1>
        {error && <p style={{ color: "red", fontWeight: "bold" }}>🚨 {error}</p>}
        {stocks.length > 0 ? (
            <table border="1">
              <thead>
              <tr>
                <th>기준일</th>
                <th>종목명</th>
                <th>시장구분</th>
                <th>현재가</th>
                <th>등락률</th>
                <th>거래량</th>
              </tr>
              </thead>
              <tbody>
              {stocks.map((stock, index) => (
                  <tr key={index}>
                    <td>{stock.basDt?._text || "N/A"}</td>
                    <td>{stock.itmsNm?._text || "N/A"}</td>
                    <td>{stock.mrktCtg?._text || "N/A"}</td>
                    <td>{stock.clpr?._text || "N/A"}</td>
                    <td>{stock.fltRt?._text ? `${stock.fltRt._text}%` : "N/A"}</td>
                    <td>{stock.trqu?._text || "N/A"}</td>
                  </tr>
              ))}
              </tbody>
            </table>
        ) : (
            <p>데이터 로딩 중...</p>
        )}
      </div>
  );
};

export default StockList;
