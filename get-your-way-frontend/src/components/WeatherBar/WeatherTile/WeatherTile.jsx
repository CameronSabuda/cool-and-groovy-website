import React from "react";
import Card from "react-bootstrap/Card";
import "./WeatherTile.css";
import { Row, Col, Container } from "react-bootstrap";

const WeatherTile = (props) => {
  return (
    <div>
      <Card>
        <Card.Header>{props.day}</Card.Header>
        <Card.Body>
          <Container>
            <Row>
              <img
                src="http://openweathermap.org/img/wn/10d@4x.png"
                alt="light showers"
              />
            </Row>
            <Row>
              <Card.Text className="temperature-text">23°C</Card.Text>
            </Row>
            <Row className="rain-chance-text-container">
              <Col className="rain-chance-text">
                <p>37%</p>
              </Col>
              <Col>
                <img src="http://openweathermap.org/img/wn/09d.png" alt="" />
              </Col>
            </Row>
          </Container>
        </Card.Body>
      </Card>

      {/* <thead></thead>
      <tbody>
        <tr>
          <td>Tuesday</td>
          <td>
            <img src="http://openweathermap.org/img/wn/10d@4x.png" alt="" />
          </td>
        </tr>
        <tr font-size="">23°C</tr>
        <tr>
          <td>
            <img src="./src/Assets/rain.png" alt="" />
          </td>
          <td>37%</td>
        </tr>
      </tbody> */}
    </div>
  );
};

export default WeatherTile;
