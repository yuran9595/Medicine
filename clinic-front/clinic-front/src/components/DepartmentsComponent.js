import React, { useEffect, useState } from "react";
import { Row, Col, Button, Card } from "react-bootstrap";
import lab from "../asserts/laboratory.jpg";
import oper from "../asserts/operationDepart.jpg";
import teeth from "../asserts/teethDepart.jpg";
import axios from "axios";

const DepartmentsComponent = () => {
  const PATH = "http://localhost:8082/api/v1/public/departments";
  const [departments, setDepartments] = useState([]);
  const images = [lab, oper, teeth];

  // const getDepartments = (e) => {
  //   axios
  //     .get(PATH)
  //     .then((res) => {
  //       console.log(res.data);
  //       return departments;
  //     })
  //     .catch((err) => {
  //       // Handle error
  //       console.log(err);
  //     });
  // };
  useEffect(() => {
    axios
      .get(PATH)
      .then((res) => {
        console.log(res.data);
        setDepartments(res.data);
        console.log(departments);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <>
      <Row>
        {
            departments.map(department => 
            <Col sm={4} key={department.id}> 
            <Card style={{ width: "18rem" }} className="me-5">
            <Card.Img variant="top" src={images[1]} />
            <Card.Body>
              <Card.Title>{department.name}</Card.Title>
              <Card.Text>{department.description}</Card.Text>
              <Button variant="primary" href={`/department/${department.id}`}>Details</Button>
            </Card.Body>
          </Card>
          </Col>)
        }
      </Row>
    </>
  );
};

export default DepartmentsComponent;
