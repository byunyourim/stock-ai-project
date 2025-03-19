import React from "react";StockList
import StockList from "./components/StockList"; // StockList.js를 불러옴

function App() {
  return (
      <div className="App">
        <h1>주식 조회 및 추천 시스템</h1>
        <StockList/>
      </div>
  );
}

export default App;
