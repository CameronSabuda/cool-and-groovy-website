import React from "react";
import { Container, Row, Col } from "react-bootstrap";

const Footer = () => {
  return (
    <div className="footer fixed-bottom">
      <Container>
        <hr />
        <Row className="d-flex justify-content-center">
          <Col className="me-2">
            <p>
              &copy;Get Your Way {new Date().getFullYear()}. All rights
              reserved.
            </p>
          </Col>
          <Col>
            <a href="#privacy-page">Privacy</a> |{" "}
            <a href="#site-map">Sitemap</a>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Footer;
