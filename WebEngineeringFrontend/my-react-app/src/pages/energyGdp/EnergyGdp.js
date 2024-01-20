import NavBar from '../../components/NavBar';
import './EnergyGdp.css'
import React, { useState } from 'react';
import InputFormEnergyGdp from "../../components/InputFormEnergyGdp";
import ResultsHeader from "../../components/ResultsHeader";
import WebFormBigEnergy from "../../components/WebFormBigEnergy";
import WebFormSmall from '../../components/WebFormSmall';
import ResultsEnergy from '../../components/ResultsEnergy';

function Energy() {
    const [dataRetrieve, setDataRetrieve] = useState([]);

    const [dataCreate, setDataCreate] = useState([]);
    const [countryCreate, setCountryCreate] = useState("");
    const [yearCreate, setYearCreate] = useState();
    const [energyPerCapitaCreate, setEnergyPerCapitaCreate] = useState();
    const [energyPerGdpCreate, setEnergyPerGdpCreate] = useState();

    const [dataUpdate, setDataUpdate] = useState([]);
    const [countryUpdate, setCountryUpdate] = useState("");
    const [yearUpdate, setYearUpdate] = useState();
    const [energyPerCapitaUpdate, setEnergyPerCapitaUpdate] = useState();
    const [energyPerGdpUpdate, setEnergyPerGdpUpdate] = useState();

    const [dataDelete, setDataDelete] = useState([]);
    const [countryDelete, setCountryDelete] = useState("");
    const [yearDelete, setYearDelete] = useState();


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
        setDataRetrieve([]);
        setDataUpdate([]);
        setDataDelete([]);
        if (countryCreate.length > 3) {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({country: countryCreate, year: yearCreate, energyPerCapita: energyPerCapitaCreate, energyPerGdp: energyPerGdpCreate})
            };
            fetch("http://localhost:8080/countries/country/energy", requestOptions)
            .then(response => response.json())
            .then(json => setDataCreate(json))
            .catch(error => alert("Data not found")); 
        } else {
            alert("We do not support such format yet");
        }
    }

    const handleSubmitUpdate = (event) => {
        event.preventDefault();
        setDataCreate([]);
        setDataRetrieve([]);
        setDataDelete([]);
        if (countryUpdate.length > 3) {
            const requestOptions = {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({energyPerCapita: energyPerCapitaUpdate, energyPerGdp: energyPerGdpUpdate})
            };
            fetch("http://localhost:8080/countries/" + countryUpdate + "/" + yearUpdate + "/energy", requestOptions)
            .then(response => response.json())
            .then(json => setDataUpdate(json))
            .catch(error => alert("Data not found"));
        } else {
            alert("We do not support such format yet");
        }
    }

    const handleSubmitDelete = (event) => {
        event.preventDefault();
        setDataCreate([]);
        setDataUpdate([]);
        setDataRetrieve([]);
        if (countryDelete.length > 3) {
            const requestOptions = {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            };
            fetch("http://localhost:8080/countries/" + countryDelete + "/" + yearDelete + "/" + "energy", requestOptions)
            .then(response => response.json())
            .then(json => setDataDelete(json))
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
                    <InputFormEnergyGdp setDataCreate={setDataCreate} setDataUpdate={setDataUpdate} setDataDelete={setDataUpdate} setDataRetrieve={setDataRetrieve}/>
                </div>
                <WebFormBigEnergy header="Create" handleSubmit={handleSubmitCreate} country={countryCreate} energyPerCapita={energyPerCapitaCreate} energyPerGdp={energyPerGdpCreate} year={yearCreate} changeCountry={changeCountryCreate} changeEnergyPerCapita={changeEnergyPerCapitaCreate} changeEnergyPerGdp={changeEnergyPerGdpCreate} changeYear={changeYearCreate} button="Create" />
                <WebFormBigEnergy header="Update" handleSubmit={handleSubmitUpdate} country={countryUpdate} energyPerCapita={energyPerCapitaUpdate} energyPerGdp={energyPerGdpUpdate} year={yearUpdate} changeCountry={changeCountryUpdate} changeEnergyPerCapita={changeEnergyPerCapitaUpdate} changeEnergyPerGdp={changeEnergyPerGdpUpdate} changeYear={changeYearUpdate} button="Update" />
                <WebFormSmall header="Delete" handleSubmit={handleSubmitDelete} country={countryDelete} year={yearDelete} changeCountry={changeCountryDelete} changeYear={changeYearDelete} button="Delete"/>
            </div>
            <ul className="results-list">
                <ResultsHeader empty={dataRetrieve.length === 0 && dataCreate.length === 0 && dataUpdate.length === 0 && dataDelete.length === 0}/>
                <ResultsEnergy create={dataCreate.length != 0}
                update={dataUpdate.length != 0}
                delete={dataDelete.length != 0}
                id={dataCreate.id}
                energyPerCapitaUpdate={dataUpdate.energyPerCapita}
                energyPerGdpUpdate={dataUpdate.energyPerGdp}
                message={dataDelete.message} />
                {dataRetrieve.map(info => <li className="list-element-data">Energy per capita: {info.energyPerCapita}, Energy per gdp: {info.energyPerGdp}</li>)}
            </ul>
        </div>
    );
}

export default Energy;