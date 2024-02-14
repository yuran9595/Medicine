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
import DepartmentDetails from "./components/DepartmentDetails";
import AdminComponent from "./components/AdminComponent";
import AddDepartmentComponent from "./components/AddDepartmentComponent";
import AddCategoryComponent from "./components/AddCategoryComponent";
import AddDoctorComponent from "./components/AddDoctorComponent";

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
        <Route element={<DepartmentDetails/>} exact path='/department/:id'></Route>
        <Route element={<AdminComponent/>} exact path = "/admin"></Route>
        <Route element={<AddDepartmentComponent/>} exact path="/addDepartment"></Route>
        <Route element={<AddCategoryComponent/>} exact path="/addCategory"></Route>
        <Route element={<AddDoctorComponent/>} exact path="/addDoctor"></Route>
      </Routes>
      <FooterComponent/>
    </BrowserRouter>
    </AuthContext.Provider>
  );
}

export default App;
