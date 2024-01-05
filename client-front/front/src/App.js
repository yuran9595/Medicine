import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import MyNavBar from "./components/MyNavBar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from "./components/HomeComponent";
import PricingComponent from "./components/PricingComponent";
import { AuthContext } from "./context/AuthContext";
import { useContext, useState } from "react";
import FooterComponent from "./components/FooterComponent";
import AboutUsComponent from "./components/AboutUsComponent";

function App() {

  const [auth, setAuth] = useState(localStorage.getItem("isAuth"));
  return (
    <AuthContext.Provider value={auth}>
    <BrowserRouter>
      <MyNavBar />
      <Routes>
        <Route element={<HomeComponent/>} exact path = '/home'></Route>
        <Route element={<PricingComponent/>} exact path = '/pricing'></Route>
        <Route element={<AboutUsComponent/>} exact path='/aboutUs'></Route>
      </Routes>
      <FooterComponent/>
    </BrowserRouter>
    </AuthContext.Provider>
  );
}

export default App;
