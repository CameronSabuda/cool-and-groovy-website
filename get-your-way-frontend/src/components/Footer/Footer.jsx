import React from "react";
import { Container, Row, Col } from "react-bootstrap";


const Footer = () => {
  return (
    <div className="bg-light mt-auto mx-0 py-4 text-white overflow-hidden">
      <Container>
        <Row className="d-flex justify-content-center mx-3">
          <Col md={8} className="me-2">
            <p>
              &copy;Get Your Way {new Date().getFullYear()}. All rights
              reserved.
            </p>
          </Col>
          <Col md={8}>
            <a href="#privacy-page">Privacy</a> |{" "}
            <a href="#site-map">Sitemap</a>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Footer;
