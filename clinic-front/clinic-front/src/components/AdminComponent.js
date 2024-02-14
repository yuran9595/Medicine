import React from "react";
import { Col, Nav, Row } from 'react-bootstrap';
const AdminComponent = () => {
  return (
    <Row>
      <Col sm={2}>
        <Nav>
          <Nav.Link href="/addDepartment">
            <h2>Add Department</h2>
          </Nav.Link>
          <Nav.Link href="/addCategory">
            <h2>Add Category</h2>
          </Nav.Link>
          <Nav.Link href="/addDoctor">
            <h2>Add Doctor</h2>
          </Nav.Link>
        </Nav>
      </Col>
      <Col sm={10}></Col>
    </Row>
  );
};

export default AdminComponent;
