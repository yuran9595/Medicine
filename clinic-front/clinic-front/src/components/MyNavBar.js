import { Button } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Modal from "react-bootstrap/Modal";
import { useContext, useState, useEffect } from "react";
import Form from "react-bootstrap/Form";
import "./MyNavBar.css";
import axios from "axios";
import { AuthContext } from "../context/AuthContext";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";

function MyNavBar() {
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleCloseRegistration = () => setShowRegistration(false);
  const handleShow = () => {
    setShow(true);
    console.log(authFromContext);
  };

  const [showRegistration, setShowRegistration] = useState(false);
  const handleRegistrationClose = () => setShowRegistration(false);
  const handleRegistrationShow = () => setShowRegistration(true);
  const authFromContext = useContext(AuthContext);

  const AUTH_USER = "http://localhost:8082/api/v1/auth/authenticate";
  const REGISTER_USER = "http://localhost:8082/api/v1/auth/register";
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [userRole, setUserRole] = useState(localStorage.getItem("USER_ROLE"));
  const [auth, setAuth] = useState(localStorage.getItem("isAuth"));
  const NAVIGATE = useNavigate();


  const goBack = () => NAVIGATE(-1);
  const goHome = () => NAVIGATE("/home");

  useEffect(() => {
    if(localStorage.getItem("token") == null){
      setAuth("false");
      goHome();
    } else{
     let token = localStorage.getItem("token");
     const decoded = jwtDecode(localStorage.getItem("token"));
     console.log(decoded.exp * 1000 - new Date().getTime());
     if(decoded.exp * 1000 < new Date().getTime()){
      setAuth("false");
      goHome();
     }
    }
  }, []);

  const getToken = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(AUTH_USER, {
        login: username,
        password: password,
      });
      const token = response.data.token;

      localStorage.setItem("token", token);
      setAuth("true");
      localStorage.setItem("isAuth", "true");
      const decoded = jwtDecode(localStorage.getItem("token"));
      console.log(decoded.roles[0]);
      setUserRole(decoded.roles[0]);
      localStorage.setItem("USER_ROLE", decoded.roles[0]);
      setShow(false);
      goHome();
      return token;
    } catch (e) {
      alert("Wrong Credentials!");
      console.error(e);
    }

  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const token = await getToken({ username, password });
      if (token) {
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
        window.location.replace("http://localhost:3000/");
      }
      handleClose();
    } catch (error) {
      console.error("Login failed:", error);
    }
  };

  const handleRegistration = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post(REGISTER_USER, {
        login: username,
        password: password,
        role: userRole, // Assuming you want to send the user's role during registration
      });

      console.log("Registration successful:", response.data);

      const token = await getToken({ username, password });

      if (token) {
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
        window.location.replace("http://localhost:3000/");
      }

      handleCloseRegistration();
    } catch (error) {
      console.error("Registration failed:", error);
    }

  };
  const handleLogOut = (e) => {
    e.preventDefault();
    localStorage.removeItem("token");
    setAuth("false");
    localStorage.setItem("isAuth", "false");
    setUserRole("");
    goHome();
  };
  return (
    <>
      <Navbar
        collapseOnSelect
        expand="lg"
        bg="dark"
        variant="dark"
        sticky="top"
      >
        <Container>
          <Navbar.Brand href="/">Medical center</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/home">Home</Nav.Link>
              <Nav.Link href="/aboutUs">About Us</Nav.Link>
            </Nav>
            <Nav>
              {auth === "false"
                ? <>
                  <Button
                    variant="primary"
                    className="me-2"
                    onClick={handleShow}
                  >
                    Sign In
                  </Button>
                  <Button variant="primary" className="me-2"
                    onClick={handleRegistrationShow}>
                    Registration
                  </Button>
                </>
                : <>
                  {userRole === 'ROLE_ADMIN'
                    ? <Button
                      variant="danger"
                      className="me-2"
                      href="/admin"
                    >
                      Admin Panel
                    </Button>
                    : <></>
                  }
                  <Button variant="primary" onClick={handleLogOut}>
                    Log out
                  </Button>
                </>

              }

            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Login</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Your Login</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter your login"
                autoFocus
                value={username}
                onChange={(e) => setUsername(e.target.value)} // Обработчик изменения значения
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                placeholder="Enter your password"
                autoFocus
                value={password}
                onChange={(e) => setPassword(e.target.value)} // Обработчик изменения значения
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>

          <Button variant="primary" onClick={getToken}>
            Login
          </Button>
        </Modal.Footer>
      </Modal>

      <Modal show={showRegistration} onHide={handleRegistrationClose}>
        <Modal.Header closeButton>
          <Modal.Title>Registration</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form onSubmit={handleRegistration}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Your Login</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter your login"
                autoFocus
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                placeholder="Enter your password"
                autoFocus
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleRegistrationClose}>
            Close
          </Button>

          <Button variant="primary" onClick={handleRegistration}>
            Register
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default MyNavBar;
