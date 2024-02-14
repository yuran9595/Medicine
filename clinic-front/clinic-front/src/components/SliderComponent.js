import Carousel from 'react-bootstrap/Carousel';
import clinic1 from '../asserts/clinic1.jpg';
import clinic2 from '../asserts/clinic2.jpg';
import clinic3 from '../asserts/clinic3.jpg';
import { Col, Nav, Row } from 'react-bootstrap';
import Image from 'react-bootstrap/Image';

function SliderComponent() {
  return (
    <Row>
        <Col sm = {2}>
          <Nav>
            <Nav.Link href='/home'><h2>Home</h2></Nav.Link>
            <Nav.Link href='/pricing'><h2>Pricing</h2></Nav.Link>
            <Nav.Link href='/home'><h2>HomeAlso</h2></Nav.Link>
          </Nav>


        </Col>
        <Col sm={10}>
    <Carousel fade>
      <Carousel.Item>
        <Image src = {clinic1} height='400' width='900' thumbnail/>
        <Carousel.Caption>
          <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
      <Image src = {clinic2} height='400' width='900' thumbnail/>
        <Carousel.Caption>
          <h3>Second slide label</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
      <Image src = {clinic3} height='400' width='900' thumbnail/>
        <Carousel.Caption>
          <h3>Third slide label</h3>
          <p>
            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
    </Col>
    </Row>
  );
}

export default SliderComponent;