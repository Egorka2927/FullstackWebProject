import NavBar from '../../components/NavBar';
import './Countries.css';
import React from 'react';
import InputFormYearCountries from '../../components/InputFormYearCountries';
import InputFormYearsCountries from '../../components/InputFormYearsCountries';

function Countries() {
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
                        <InputFormYearCountries/>
                    </div>
                </div>
                <div className="menu-container menu-container-countries">
                    <h2>Retrieve</h2>
                    <div>
                        <InputFormYearsCountries/>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Countries;