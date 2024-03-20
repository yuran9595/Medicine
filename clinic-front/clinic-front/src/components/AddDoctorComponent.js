import Form from "react-bootstrap/Form";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Col, Row, Nav, Button } from "react-bootstrap";

const AddDoctorComponent = () => {
  const [categories, setCategories] = useState([]);
  const [firstName, setFirstName] = useState("");
  const [middleName, setMiddleName] = useState("");
  const [lastName, setLastName] = useState("");
  const [specialityDescription, setSpecialityDescription] = useState("");
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [typeServiceId, setTypeServiceId] = useState(0);
  const [type, setType] = useState("");
  const PATH_GET_CATEGORIES =
    "http://localhost:8082/api/v1/public/typeServices";
  const PATH = "http://localhost:8082/api/v1/admin/addDoctor";

  const handleSubmit = async (event) => {
    event.preventDefault();
    axios
      .post(
        PATH,
        {
          login: login,
          password: password,
          firstName: firstName,
          middleName: middleName,
          lastName: lastName,
          specialityDescription: specialityDescription,
           typeServiceId: typeServiceId
        },
        {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        }
      )
      .then((response) => console.log(response))
      .catch((error) => alert(error.response.data));
  };

  const handleChange = (event) => {
     setTypeServiceId(event.target.value);
  };

  useEffect(() => {
    axios
      .get(PATH_GET_CATEGORIES)
      .then((res) => {
        console.log(res.data);
        setCategories(res.data);
        setTypeServiceId(res.data[0].id);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label>Choose category</Form.Label>
        <Form.Select onChange={handleChange}>
          {categories.map((category) => (
            <option key={category.id} value={category.id}>
              {category.name}
            </option>
          ))}
        </Form.Select>
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
        <Form.Label>Enter First Name</Form.Label>
        <Form.Control
          type="text"
          placeholder="First name"
          autoFocus
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
        <Form.Label>Enter middle name</Form.Label>
        <Form.Control
          type="text"
          placeholder="Middle Name"
          autoFocus
          value={middleName}
          onChange={(e) => setMiddleName(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
        <Form.Label>Enter last name</Form.Label>
        <Form.Control
          type="text"
          placeholder="Last Name"
          autoFocus
          value={lastName}
          onChange={(e) => setLastName(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput5">
        <Form.Label>Enter Login</Form.Label>
        <Form.Control
          type="text"
          placeholder="Login"
          autoFocus
          value={login}
          onChange={(e) => setLogin(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput6">
        <Form.Label>Enter Password</Form.Label>
        <Form.Control
          type="text"
          placeholder="Password"
          autoFocus
          value={password}
          onChange={(e) => setPassword(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput7">
        <Form.Label>Enter Speciality Description</Form.Label>
        <Form.Control
          type="text"
          placeholder="Speciality Description"
          autoFocus
          value={specialityDescription}
          onChange={(e) => setSpecialityDescription(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Button onClick={handleSubmit}>Add Doctor</Button>
    </Form>
  );
};

export default AddDoctorComponent;
