import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Main from './pages/mainPage/MainPage';
import reportWebVitals from './reportWebVitals';
import PopGdp from './pages/popGdp/PopGdp';
import EnergyGdp from './pages/energyGdp/EnergyGdp';
import Emissions from './pages/emissionsData/Emissions';
import Temperature from './pages/temperature/Temperature';
import Countries from './pages/countries/Countries';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route index element={<Main />}/>
      <Route path="/popGdp/" element={<PopGdp/>}/>
      <Route path="/energyGdp/" element={<EnergyGdp/>}/>
      <Route path="/emissions/" element={<Emissions/>}/>
      <Route path="/temperature/" element={<Temperature/>}/>
      <Route path="/countries/" element={<Countries/>}/>
    </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
