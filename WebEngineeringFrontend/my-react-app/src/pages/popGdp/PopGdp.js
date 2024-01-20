import { useState } from "react";
import "./PopGdp.css";
import NavBar from "../../components/NavBar";
import ResultsHeader from "../../components/ResultsHeader";
import Results from "../../components/Results";
import WebFormSmall from "../../components/WebFormSmall";
import WebFormBig from "../../components/WebFormBig";

function PopGdp() {
    const [dataRetrieve, setDataRetrieve] = useState([]);
    const [countryRetrieve, setCountryRetrieve] = useState("");
    const [yearRetrieve, setYearRetrieve] = useState();

    const [dataCreate, setDataCreate] = useState([]);
    const [countryCreate, setCountryCreate] = useState("");
    const [yearCreate, setYearCreate] = useState();
    const [populationCreate, setPopulationCreate] = useState();
    const [gdpCreate, setGdpCreate] = useState();

    const [dataUpdate, setDataUpdate] = useState([]);
    const [countryUpdate, setCountryUpdate] = useState("");
    const [yearUpdate, setYearUpdate] = useState();
    const [populationUpdate, setPopulationUpdate] = useState();
    const [gdpUpdate, setGdpUpdate] = useState();

    const [dataDelete, setDataDelete] = useState([]);
    const [countryDelete, setCountryDelete] = useState("");
    const [yearDelete, setYearDelete] = useState();

    const changeCountryRetrieve = event => {
        setCountryRetrieve(event.target.value);
    }

    const changeYearRetrieve = event => {
        setYearRetrieve(event.target.value);
    }

    const changeCountryCreate = event => {
        setCountryCreate(event.target.value);
    }

    const changeYearCreate = event => {
        setYearCreate(event.target.value);
    }

    const changePopulationCreate = event => {
        setPopulationCreate(event.target.value);
    }

    const changeGdpCreate = event => {
        setGdpCreate(event.target.value);
    }

    const changeCountryUpdate = event => {
        setCountryUpdate(event.target.value);
    }

    const changeYearUpdate = event => {
        setYearUpdate(event.target.value);
    }

    const changePopulationUpdate = event => {
        setPopulationUpdate(event.target.value);
    }

    const changeGdpUpdate = event => {
        setGdpUpdate(event.target.value);
    }

    const changeCountryDelete = event => {
        setCountryDelete(event.target.value);
    }

    const changeYearDelete = event => {
        setYearDelete(event.target.value);
    }

    const handleSubmitRetrieve = (event) => {
        event.preventDefault();
        setDataCreate([]);
        setDataUpdate([]);
        setDataDelete([]);
        if (countryRetrieve.length > 3) {
            fetch("http://localhost:8080/countries/" + countryRetrieve + "/" + yearRetrieve + "/population-gdp-name")
            .then(response => response.json())
            .then(json => setDataRetrieve(json))
            .catch(error => alert("Data not found"));
        } else if (countryRetrieve.length === 3) {
            fetch("http://localhost:8080/countries/" + countryRetrieve.toUpperCase() + "/" + yearRetrieve + "/population-gdp-code")
            .then(response => response.json())
            .then(json => setDataRetrieve(json))
            .catch(error => alert("Data not found"));
        } else {
            alert("Something is wrong");
        }
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
                body: JSON.stringify({country: countryCreate, year: yearCreate, population: populationCreate, gdp: gdpCreate})
            };
            fetch("http://localhost:8080/countries/country/population-gdp-name", requestOptions)
            .then(response => response.json())
            .then(json => setDataCreate(json))
            .catch(error => alert("Data not found"));
        } else if (countryCreate.length === 3) {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({isoCode: countryCreate.toUpperCase(), year: yearCreate, population: populationCreate, gdp: gdpCreate})
            };
            fetch("http://localhost:8080/countries/iso-code/population-gdp-code", requestOptions)
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
                body: JSON.stringify({population: populationUpdate, gdp: gdpUpdate})
            };
            fetch("http://localhost:8080/countries/" + countryUpdate + "/" + yearUpdate + "/population-gdp-name", requestOptions)
            .then(response => response.json())
            .then(json => setDataUpdate(json))
            .catch(error => alert("Data not found"));
        } else if (countryUpdate.length === 3) {
            const requestOptions = {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({population: populationUpdate, gdp: gdpUpdate})
            };
            fetch("http://localhost:8080/countries/" + countryUpdate.toUpperCase() + "/" + yearUpdate + "/population-gdp-code", requestOptions)
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
            fetch("http://localhost:8080/countries/" + countryDelete + "/" + yearDelete + "/" + "population-gdp-name", requestOptions)
            .then(response => response.json())
            .then(json => setDataDelete(json))
            .catch(error => alert("Data not found"));
        } else if (countryDelete.length === 3) {
            const requestOptions = {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            };
            fetch("http://localhost:8080/countries/" + countryDelete.toUpperCase() + "/" + yearDelete + "/" + "population-gdp-code", requestOptions)
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
                Population and gdp data
            </h1>
            <div className="menus-container flex">
                <WebFormSmall header="Retrieve" handleSubmit={handleSubmitRetrieve} country={countryRetrieve} year={yearRetrieve} changeCountry={changeCountryRetrieve} changeYear={changeYearRetrieve} button="Retrieve"/>
                <WebFormBig header="Create" handleSubmit={handleSubmitCreate} country={countryCreate} population={populationCreate} gdp={gdpCreate} year={yearCreate} changeCountry={changeCountryCreate} changePopulation={changePopulationCreate} changeGdp={changeGdpCreate} changeYear={changeYearCreate} button="Create"/>
                <WebFormBig header="Update" handleSubmit={handleSubmitUpdate} country={countryUpdate} population={populationUpdate} gdp={gdpUpdate} year={yearUpdate} changeCountry={changeCountryUpdate} changePopulation={changePopulationUpdate} changeGdp={changeGdpUpdate} changeYear={changeYearUpdate} button="Update"/>
                <WebFormSmall header="Delete" handleSubmit={handleSubmitDelete} country={countryDelete} year={yearDelete} changeCountry={changeCountryDelete} changeYear={changeYearDelete} button="Delete"/>
            </div>
            <ul className="results-list">
                <ResultsHeader empty={dataRetrieve.length === 0 && dataCreate.length === 0 && dataUpdate.length === 0 && dataDelete.length === 0}/>
                <Results retrieve={dataRetrieve.length != 0}
                create={dataCreate.length != 0}
                update={dataUpdate.length != 0}
                delete={dataDelete.length != 0}
                populationRetrieve={dataRetrieve.population}
                gdpRetrieve={dataRetrieve.gdp}
                id={dataCreate.id}
                populationUpdate={dataUpdate.population}
                gdpUpdate={dataUpdate.gdp}
                message={dataDelete.message} />
            </ul> 
        </div>
    );
}

export default PopGdp;