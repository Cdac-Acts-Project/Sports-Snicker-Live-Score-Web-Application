import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./components/HomePage";
import RegisterUser from "./components/Auth/RegisterUser";
import Login from "./components/Auth/Login";
import SportsHomePage from "./components/app/SportsHomePage";
import Football from "./components/app/Football/Football";
import Hockey from "./components/app/Hockey/Hockey";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<HomePage/>}/>
          <Route path="/sign-up" element={<RegisterUser/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/sports-snicker" element={<SportsHomePage/>}/>
          <Route path="/sports-snicker/football" element={<Football/>}/>
          <Route path="/sports-snicker/hockey" element={<Hockey/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
