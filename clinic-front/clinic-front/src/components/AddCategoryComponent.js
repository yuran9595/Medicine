import GetAllCategories from "./GetAllCategories";
import { Col, Row, Nav, Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import axios from "axios";
import React, { useEffect, useState } from "react";

const AddCategoryComponent = () => {
  const [departments, setDepartments] = useState([]);
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [departmentId, setDepartmentId] = useState(1);
  const PATH = "http://localhost:8082/api/v1/admin/addTypeService";
  const PATH_GET_DEPARTMENTS = "http://localhost:8082/api/v1/public/departments"
  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(departmentId);
    axios
      .post(
        PATH,
        {
          name: name,
          description: description,
          departmentId: departmentId
        },
        {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        }
      )
      .then((response) => console.log(response))
      .catch((error) => console.error(error));
  };

  const handleChange = event => {
    console.log(event.target.value);
    setDepartmentId(event.target.value);
  };

  useEffect(() => {
    axios
      .get(PATH_GET_DEPARTMENTS)
      .then((res) => {
        setDepartments(res.data);
        setDepartmentId(res.data[0].id);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label>Name department</Form.Label>
        <Form.Select onChange={handleChange}>
          {departments.map((department) => (
            <option key={department.id}
              value={department.id}
            >
              {department.name}
            </option>
          ))}
        </Form.Select>
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
        <Form.Label>Name Type Service</Form.Label>
        <Form.Control
          type="text"
          placeholder="Name"
          autoFocus
          value={name}
          onChange={(e) => setName(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
        <Form.Label>Description</Form.Label>
        <Form.Control
          type="text"
          placeholder="Description"
          autoFocus
          value={description}
          onChange={(e) => setDescription(e.target.value)} // Обработчик изменения значения
        />
      </Form.Group>

      <Button onClick={handleSubmit}>Add Category</Button>
    </Form>
  );
};

export default AddCategoryComponent;
