function ResultsHeader(props) {
    if (!props.empty) {
        return (
            <h3>Results</h3>
        );
    }
    return;
}

export default ResultsHeader;