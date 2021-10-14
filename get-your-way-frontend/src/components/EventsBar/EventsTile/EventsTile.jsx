import React from "react";
import Card from "react-bootstrap/Card";
import { Row, Col, Container, Button, Figure} from "react-bootstrap";
import PropTypes from "prop-types";
import './EventsTile.css'



const EventsTile = (props) => {
  const label = "Concert"
  return (
    <div>
      <Card className="bg-primary my-5 mx-2  w-auto shadow-lg">
        <span className="tag">{label}</span>
        <Card.Img className="pt-3 w-50 vh-50 mx-auto" src="https://www.svgrepo.com/show/268564/rock-and-roll-concert.svg" />
        {/* <Card.Img className="pt-3 w-50 vh-50 mx-auto" src="https://www.svgrepo.com/show/268564/rock-and-roll-concert.svg" /> */}
        
      <Card.Body className=" pt-1" >
          <Card.Title className="text-white mb-2">Alexander O'Neal</Card.Title>
          <Card.Text className="text-white">30-01-21</Card.Text>
          <Container fluid>
            <Row className="d-flex justify-content-between">
              {/* Col 1 */}
              <Col className="text-white">
                   <Row>
                     <p className=""> Start: 18:00 </p>
                     <p> End: 18:00 </p>
                   </Row>
              </Col>

              {/* Col 2 */}
              <Col className="text-white ">
                  <Row>
                    <Button variant="secondary" size="sm" className="mb-2"> Find out more </Button>
                  </Row>
                  <Row className="text-center">
                      <p className="p-0 m-0">4.649KM away</p>
                  </Row>
              </Col>
            </Row>
          </Container>

      </Card.Body>

      </Card>
        
    </div>
  );
};

export default EventsTile;
