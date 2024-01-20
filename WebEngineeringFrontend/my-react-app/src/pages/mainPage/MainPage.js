import NavBar from "../../components/NavBar";
import Image from "./Welcome.svg";
import "./MainPage.css";

function MainPage() {
    return (
        <div className="main-container flex">
            <NavBar />
            <h1 className="main-header">WELCOME !</h1>
            <img src={Image} alt="Image"/>
        </div>
    );
}

export default MainPage;