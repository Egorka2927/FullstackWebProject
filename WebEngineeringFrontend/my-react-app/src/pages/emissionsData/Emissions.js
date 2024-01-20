import { useState } from "react";
import "./Emissions.css";
import NavBar from "../../components/NavBar";

function Emissions() {
    const [country, setCountry] = useState("");

    const [countryFiltered, setCountryFiltered] = useState("");
    const [yearFiltered, setYearFiltered] = useState("");

    const changeCountry = event => {
        setCountry(event.target.value);
    }

    const changeCountryFiltered = event => {
        setCountryFiltered(event.target.value);
    }

    const changeYearFiltered = event => {
        setYearFiltered(event.target.value);
    }
    
    const handleSubmit = (event) => {
        event.preventDefault();
        if (country.length > 3) {
            fetch("http://localhost:8080/countries/" + country + "/emissions-name")
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found"));
        } else if (country.length === 3) {
            fetch("http://localhost:8080/countries/" + country.toUpperCase() + "/emissions-code")
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found"));
        } else {
            alert("Something is wrong");
        }
    }

    const handleSubmitYear = (event) => {
        event.preventDefault();
        if (countryFiltered.length > 3 && yearFiltered.length > 0) {
            fetch("http://localhost:8080/countries/" + countryFiltered + "/" + yearFiltered + "/emissions-name")
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => alert("Data not found"));
        } else if (countryFiltered.length === 3 && yearFiltered.length > 0) {
            fetch("http://localhost:8080/countries/" + countryFiltered.toUpperCase() + "/" + yearFiltered + "/emissions-code")
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
                Emissions data
            </h1>
            <div className="menus-container-emissions flex">
                <div className="menu-container menu-container-emissions menu-container-emissions-left">
                    <h2>Retrieve</h2>
                    <form onSubmit={handleSubmit} className="country-form flex">
                        <label htmlFor="country">Country name or code</label>
                        <input className="last-input" type="text" id="country" name="country" value={country} onChange={changeCountry} placeholder="Enter country"/>
                        <button type="submit" className="submit-button">
                            Retrieve
                        </button>
                    </form>
                </div>
                <div className="menu-container menu-container-emissions">
                    <h2>Retrieve filtered</h2>
                    <form onSubmit={handleSubmitYear} className="country-form flex">
                        <label htmlFor="country">Country name or code</label>
                        <input type="text" id="country" name="country" value={countryFiltered} onChange={changeCountryFiltered} placeholder="Enter country"/>
                        <label htmlFor="year">Year</label>
                        <input className="last-input" type="text" id="year" name="year" value={yearFiltered} onChange={changeYearFiltered} placeholder="Enter year"/>
                        <button type="submit" className="submit-button">
                            Retrieve
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Emissions;