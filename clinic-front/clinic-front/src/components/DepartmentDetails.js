import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import Table from "react-bootstrap/Table";
import { Col, Row, Nav, Button } from "react-bootstrap";

const DepartmentDetails = () => {
  let { id } = useParams();
  const [typeServices, setTypeServices] = useState([]);
  const PATH = "http://localhost:8082/api/v1/public/department/" + id;
  useEffect(() => {
    axios
      .get(PATH)
      .then((res) => {
        console.log(res.data.typeServices);
        setTypeServices(res.data.typeServices);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <Row>
        <Col sm = '2'>
        <Nav>
            <Nav.Link href='/home'><h2>Home</h2></Nav.Link>
            <Nav.Link href='/pricing'><h2>Pricing</h2></Nav.Link>
            <Nav.Link href='/home'><h2>HomeAlso</h2></Nav.Link>
          </Nav>
        </Col>
        <Col sm = '8'>
        <Table striped bordered hover variant="dark">
      {console.log(typeServices)}
      <thead>
        <tr>
          <th>Department id</th>
          <th>Name</th>
          <th>Description</th>
          <th>List of doctors</th>
        </tr>
      </thead>
      <tbody>
        {typeServices.map((typeService) => (
          <tr>
            <td>{typeService.id}</td>
            <td>{typeService.name}</td>
            <td>{typeService.description}</td>
            <td><Button href="/getDoctorList">Get list</Button></td>
          </tr>
        ))}
      </tbody>
    </Table>
        </Col>
    </Row>
  );
};

export default DepartmentDetails;
