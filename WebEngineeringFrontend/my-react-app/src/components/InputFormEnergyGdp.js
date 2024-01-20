import React, { useState } from 'react';

function InputFormEnergyGdp(props) {
    const[year, setYear] = useState();
    const[batchSize, setBatchSize] = useState();
    const[batchNumber, setBatchNumber] = useState();

    const getData = (event) => {
        event.preventDefault();
        props.setDataCreate([]);
        props.setDataUpdate([]);
        props.setDataDelete([]);
        if (batchSize != 0) {
            fetch("http://localhost:8080/countries/" + year + "/energy?batch_size=" + batchSize + "&batch_number=" + batchNumber)
                .then(response => response.json())
                .then(json => props.setDataRetrieve(json))
                .catch(error => console.error('Error fetching data:', error));
        }
    }

    const changeYear = event => {
        setYear(event.target.value);
    }

    const changeBatchSize = event => {
        setBatchSize(event.target.value);
    }

    const changeBatchNumber = event => {
        setBatchNumber(event.target.value);
    }

    return (
        <form className="country-form flex" onSubmit={getData}>
            <label className="label flex" htmlFor="year">
                Year
            </label>
            <input type="text" id="year" name="year" placeholder="Enter year" value={year} onChange={changeYear}></input>

            <label className="label flex" htmlFor="batchSize">
                Batch Size
            </label>
            <input type="text" id="batchSize" name="batchSize" placeholder="Enter size" value={batchSize} onChange={changeBatchSize}></input>

            <label className="label flex" htmlFor="batchNumber">
                Batch Number
            </label>
            <input type="text" id="batchNumber" name="batchNumber" placeholder="Enter number" value={batchNumber} onChange={changeBatchNumber}></input>

            <button type="submit" className="submit-button">Retrieve</button>
        </form>
    );
}

export default InputFormEnergyGdp;