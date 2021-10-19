import React from "react";
import "./NavigationBar.css";
import { Navbar, Nav, Container, Button, Image } from "react-bootstrap";
import { Link } from "react-router-dom";
import { HashLink } from 'react-router-hash-link'
import logo from "../../logo.svg";


const NavigationBar = () => {
  return (
    <>
      <Container fluid className="px-0">
        <Navbar bg="dark-alt" variant="light" expand="md" className="px-3">
          <Navbar.Brand as={Link} to="/">
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
              <Nav.Link as={HashLink} smooth to={'/#about-us'}>
                About Us
              </Nav.Link>
              <Nav.Link as={HashLink} smooth to={'/#try-it-out'}>
                Try It Out
              </Nav.Link>
              <Nav.Link as={Link} to="/movies">
                Movies
              </Nav.Link>
              <Button variant="primary" size="md" as={Link} to="/signUp" className="mx-2">
                Sign Up
              </Button>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </Container>



    </>
  );
};

export default NavigationBar;
