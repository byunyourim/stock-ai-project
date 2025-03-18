import React from "react";
import StockList from "./components/StockList"; // StockList.js를 불러옴

function App() {
  return (
      <div className="App">
        <h1>한화투자증권 주식 정보</h1>
        <StockList />
      </div>
  );
}

export default App;
