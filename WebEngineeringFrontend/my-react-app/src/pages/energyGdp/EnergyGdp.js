import NavBar from '../../components/NavBar';
import './EnergyGdp.css'
import React, { useState } from 'react';
import InputFormEnergyGdp from "../../components/InputFormEnergyGdp";
import WebFormBigEnergy from "../../components/WebFormBigEnergy";
import WebFormSmall from '../../components/WebFormSmall';

function Energy() {
    const [countryCreate, setCountryCreate] = useState("");
    const [yearCreate, setYearCreate] = useState("");
    const [energyPerCapitaCreate, setEnergyPerCapitaCreate] = useState();
    const [energyPerGdpCreate, setEnergyPerGdpCreate] = useState();

    const [countryUpdate, setCountryUpdate] = useState("");
    const [yearUpdate, setYearUpdate] = useState("");
    const [energyPerCapitaUpdate, setEnergyPerCapitaUpdate] = useState();
    const [energyPerGdpUpdate, setEnergyPerGdpUpdate] = useState();

    const [countryDelete, setCountryDelete] = useState("");
    const [yearDelete, setYearDelete] = useState("");


    const changeCountryCreate = event => {
        setCountryCreate(event.target.value);
    }

    const changeYearCreate = event => {
        setYearCreate(event.target.value);
    }

    const changeEnergyPerCapitaCreate = event => {
        setEnergyPerCapitaCreate(event.target.value);
    }

    const changeEnergyPerGdpCreate = event => {
        setEnergyPerGdpCreate(event.target.value);
    }

    const changeCountryUpdate = event => {
        setCountryUpdate(event.target.value);
    }

    const changeYearUpdate = event => {
        setYearUpdate(event.target.value);
    }

    const changeEnergyPerCapitaUpdate = event => {
        setEnergyPerCapitaUpdate(event.target.value);
    }

    const changeEnergyPerGdpUpdate = event => {
        setEnergyPerGdpUpdate(event.target.value);
    }

    const changeCountryDelete = event => {
        setCountryDelete(event.target.value);
    }

    const changeYearDelete = event => {
        setYearDelete(event.target.value);
    }

    const handleSubmitCreate = (event) => {
        event.preventDefault();
        if (countryCreate.length > 3 && yearCreate.length > 0) {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({country: countryCreate, year: yearCreate, energyPerCapita: energyPerCapitaCreate, energyPerGdp: energyPerGdpCreate})
            };
            fetch("http://localhost:8080/countries/country/energy", requestOptions)
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found")); 
        } else {
            alert("Something is wrong");
        }
    }

    const handleSubmitUpdate = (event) => {
        event.preventDefault();
        if (countryUpdate.length > 3 && yearUpdate.length > 0) {
            const requestOptions = {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({energyPerCapita: energyPerCapitaUpdate, energyPerGdp: energyPerGdpUpdate})
            };
            fetch("http://localhost:8080/countries/" + countryUpdate + "/" + yearUpdate + "/energy", requestOptions)
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found"));
        } else {
            alert("Something is wrong");
        }
    }

    const handleSubmitDelete = (event) => {
        event.preventDefault();
        if (countryDelete.length > 3 && yearDelete.length > 0) {
            const requestOptions = {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            };
            fetch("http://localhost:8080/countries/" + countryDelete + "/" + yearDelete + "/" + "energy", requestOptions)
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found"));
        } else {
            alert("Something is wrong");
        }
    }

    return (
        <div className="main-container flex">
            <NavBar />
            <h1 className="main-header">
                Energy data
            </h1>
            <div className="menus-container menus-container-energy flex">
                <div className='menu-container'>
                    <h2>
                        Retrieve
                    </h2>
                    <InputFormEnergyGdp/>
                </div>
                <WebFormBigEnergy header="Create" handleSubmit={handleSubmitCreate} country={countryCreate} energyPerCapita={energyPerCapitaCreate} energyPerGdp={energyPerGdpCreate} year={yearCreate} changeCountry={changeCountryCreate} changeEnergyPerCapita={changeEnergyPerCapitaCreate} changeEnergyPerGdp={changeEnergyPerGdpCreate} changeYear={changeYearCreate} button="Create" />
                <WebFormBigEnergy header="Update" handleSubmit={handleSubmitUpdate} country={countryUpdate} energyPerCapita={energyPerCapitaUpdate} energyPerGdp={energyPerGdpUpdate} year={yearUpdate} changeCountry={changeCountryUpdate} changeEnergyPerCapita={changeEnergyPerCapitaUpdate} changeEnergyPerGdp={changeEnergyPerGdpUpdate} changeYear={changeYearUpdate} button="Update" />
                <WebFormSmall header="Delete" handleSubmit={handleSubmitDelete} country={countryDelete} year={yearDelete} changeCountry={changeCountryDelete} changeYear={changeYearDelete} button="Delete"/>
            </div>
        </div>
    );
}

export default Energy;