import React, { useEffect, useState } from "react";
import axios from "axios";
import { Col, Row, Nav, Button } from "react-bootstrap";
import Table from "react-bootstrap/Table";

const GetDoctorListComponent = () => {

    const PATH = "http://localhost:8082/api/v1/public/getDoctors";
    const [doctors, setDoctors] = useState([]);

    useEffect(() => {
        axios
          .get(PATH)
          .then((res) => {
            console.log(res.data);
            setDoctors(res.data);
          })
          .catch((err) => {
            console.log(err);
          });
      }, [setDoctors]);
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
      <thead>
        <tr>
          <th>First name</th>
          <th>Middle name</th>
          <th>Last name</th>
          <th>Specialization description</th>
          <th>Add appointment</th>
        </tr>
      </thead>
      <tbody>
        {doctors.map((doctor) => (
          <tr key={doctor.id}>
            <td>{doctor.firstName}</td>
            <td>{doctor.middleName}</td>
            <td>{doctor.lastName}</td>
            <td>{doctor.specialityDescription}</td>
            <td><Button href=" ">Add appointment</Button></td>
          </tr>
        ))}
      </tbody>
    </Table>
        </Col>
    </Row>
    );
}

export default GetDoctorListComponent;