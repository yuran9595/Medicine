import React from 'react';
import Form from "react-bootstrap/Form";
import { useContext, useState } from "react";
import axios from "axios";
import { Button } from 'react-bootstrap';



const AddDepartmentComponent = () => {

    const [departmentName, setDepartmentName] = useState("");
    const [description, setDescription] = useState("");
    const URL = "http://localhost:8082/api/v1/admin/addDepartment";


    const handleSubmit = async (event) => {
        event.preventDefault();
        
        axios.post(URL, {
            name: departmentName,
            description: description
        }, 
        {headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        }})
        .then(response => console.log(response))
        .catch(error => console.error(error))
      };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Name department</Form.Label>
              <Form.Control
                type="text"
                placeholder="Department name"
                autoFocus
                value={departmentName}
                onChange={(e) => setDepartmentName(e.target.value)} // Обработчик изменения значения
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
            <Button onClick={handleSubmit}>
                Add Department
            </Button>
          </Form>
    );
}

export default AddDepartmentComponent;
