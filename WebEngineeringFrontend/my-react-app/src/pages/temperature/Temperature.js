import "./Temperature.css"
import React from 'react';
import NavBar from "../../components/NavBar";
import InputFormTemperature from "../../components/InputFormTemperature";
import InputFormYearTemperature from "../../components/InputFormYearTemperature";

function Temperature() {
    return (
        <div className="main-container flex">
            <NavBar />
            <h1 className="main-header">
                Temperature data
            </h1>
            <div className="menus-container menus-container-temperature flex">
                <div className="menu-container menu-container-temperature-left menu-container-temperature">
                    <InputFormTemperature/>
                </div>
                <div className="menu-container menu-container-temperature-right menu-container-temperature">
                    <h2>Retrieve filtered</h2>
                    <InputFormYearTemperature/>
                </div>
            </div>
        </div>
    );
}

export default Temperature;