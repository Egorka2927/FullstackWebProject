import NavBar from '../../components/NavBar';
import './Countries.css';
import React, { useState } from 'react';
import ResultsHeader from "../../components/ResultsHeader";
import InputFormYearCountries from '../../components/InputFormYearCountries';
import InputFormYearsCountries from '../../components/InputFormYearsCountries';

function Countries() {
    const [data, setData] = useState([]);
    return (
        <div className="main-container flex">
            <NavBar />
            <h1 className="main-header">
                Countries data
            </h1>
            <div className="menus-container-countries flex">
                <div className="menu-container menu-container-countries menu-container-countries-left">
                    <h2>Retrieve</h2>
                    <div>
                        <InputFormYearCountries setData={setData} />
                    </div>
                </div>
                <div className="menu-container menu-container-countries">
                    <h2>Retrieve</h2>
                    <div>
                        <InputFormYearsCountries setData={setData} />
                    </div>
                </div>
            </div>
            <ul className="results-list">
                <ResultsHeader empty={data.length === 0}/>
                {data.map(info => <li className="list-element-data">Country: {info.country}</li>)}
            </ul>
        </div>
    );
}

export default Countries;