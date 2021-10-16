import React from "react";
import { Container, Row, Col } from "react-bootstrap";

const Footer = () => {
  return (
    <div className="footer">
      <Container>
        <hr />
        <Row>
          <Col>
            <p>
              &copy;Get Your Way {new Date().getFullYear()}. All rights
              reserved. <a href="#privacy-page">Privacy</a> |{" "}
              <a href="#site-map">Sitemap</a>
            </p>
          </Col>
          <Col></Col>
        </Row>
      </Container>
    </div>
  );
};

export default Footer;
