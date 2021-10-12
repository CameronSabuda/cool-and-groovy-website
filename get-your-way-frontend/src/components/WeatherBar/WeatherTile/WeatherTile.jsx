import React from "react";
import Card from "react-bootstrap/Card";
import "./WeatherTile.css";
import { Row, Col, Container } from "react-bootstrap";
import PropTypes from "prop-types";

const WeatherTile = ({ data }) => {
  return (
    <div>
      <Card>
        <Card.Header>{data.day}</Card.Header>
        <Card.Body>
          <Container>
            <Row>
              <img
                src={`http://openweathermap.org/img/wn/${data.icon}@4x.png`}
                alt="Type of weather"
              />
            </Row>
            <Row>
              <Card.Text className="temperature-text">{data.temp}°C</Card.Text>
            </Row>
            <Row className="rain-chance-text-container">
              <Col className="weather-type-text">{data.description}</Col>
              <Col>
                <label class="rain-chance-text" for="cloud-icon">
                  {data.chance_of_rain}%
                </label>
                <img
                  id="cloud-icon"
                  src="http://openweathermap.org/img/wn/09d.png"
                  alt=""
                />
              </Col>
            </Row>
          </Container>
        </Card.Body>
      </Card>
    </div>
  );
};

WeatherTile.propTypes = {
  data: PropTypes.shape({
    date: PropTypes.number,
    day: PropTypes.string.isRequired,
    temp: PropTypes.number,
    chance_of_rain: PropTypes.number,
    main: PropTypes.string,
    description: PropTypes.string,
    icon: PropTypes.string,
  }),
};

// requiredFunc: PropTypes.func.isRequired,
export default WeatherTile;
