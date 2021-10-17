import React from "react";
import "./NavigationBar.css";
import { Navbar, Nav, Container, Button, Image } from "react-bootstrap";
import logo from "../../logo.svg";

const NavigationBar = () => {
  return (
    <>
      <Container>
        <Navbar bg="light" variant="light" expand="md">
          <Navbar.Brand href="#home">
            <Image
              className="d-inline-block align-top logo"
              src={logo}
              alt="GetYourWay"
              fluid
            />{" "}
            Get Your Way
          </Navbar.Brand>

          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link href="#movies">Movies</Nav.Link>
              <Nav.Link href="#about">About</Nav.Link>
              <Nav.Link href="#signup">Signup</Nav.Link>
              <Button variant="primary" size="md">
                Call to action
              </Button>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </Container>
    </>
  );
};

export default NavigationBar;
