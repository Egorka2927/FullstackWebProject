import "./Temperature.css"
import React, { useState } from 'react';
import NavBar from "../../components/NavBar";
import ResultsHeader from "../../components/ResultsHeader";
import InputFormTemperature from "../../components/InputFormTemperature";
import InputFormYearTemperature from "../../components/InputFormYearTemperature";

function Temperature() {
    const [data, setData] = useState([]);
    return (
        <div className="main-container flex">
            <NavBar />
            <h1 className="main-header">
                Temperature data
            </h1>
            <div className="menus-container menus-container-temperature flex">
                <div className="menu-container menu-container-temperature-left menu-container-temperature">
                    <InputFormTemperature setData={setData} />
                </div>
                <div className="menu-container menu-container-temperature-right menu-container-temperature">
                    <h2>Retrieve filtered</h2>
                    <InputFormYearTemperature setData={setData} />
                </div>
            </div>
            <ul className="results-list">
                <ResultsHeader empty={data.length === 0}/>
                {data.map(info => <li className="list-element-data">Share temp change: {info.shareOfTemperatureChangeFromGhg},
                 Temp change from ch4: {info.temperatureChangeFromCh4},
                 Temp change from co2: {info.temperatureChangeFromCo2},
                 Temp change from ghg: {info.temperatureChangeFromGhg},
                 Temp change from n2o: {info.temperatureChangeFromN2O}</li>)}
            </ul>
        </div>
    );
}

export default Temperature;