import React from 'react';
import { Container } from 'react-bootstrap';
import SliderComponent from './SliderComponent';
import DepartmentsComponent from './DepartmentsComponent';

const HomeComponent = () => {
    return (
        <>
        <Container style={{paddingTop:'2ren'}}>
            <SliderComponent/>
            <DepartmentsComponent/>
        </Container>
        </>
    );
}

export default HomeComponent;
