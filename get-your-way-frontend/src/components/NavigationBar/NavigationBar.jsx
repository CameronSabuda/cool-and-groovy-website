import React from "react";
import "./NavigationBar.css";
import { Navbar, Nav, Container, Button, Image } from "react-bootstrap";
import { Switch, Route, Link } from "react-router-dom";
import logo from "../../logo.svg";
// import LandingPage from "components/LandingPage/index.js"

const NavigationBar = () => {
  return (
    <>
      <Container fluid className="px-0">
        <Navbar bg="light" variant="light" expand="md" className="px-3">
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
              <Nav.Link as={Link} to="/movies">
                Movies
              </Nav.Link>
              <Nav.Link as={Link} to="/about">
                About
              </Nav.Link>
              <Button variant="primary" size="md" as={Link} to="/signup">
                Sign Up
              </Button>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </Container>
      <Switch>
        <Route path="/">{/* <LandingPage /> */}</Route>
        {/* <Route path="/movies">
          <MoviePage />
        </Route>
        <Route path="/about">
          <MoviePage />
        </Route>
        <Route path="/signup">
          <MoviePage />
        </Route>
        <Route path="/calltoaction">
          <MoviePage />
        </Route> */}
      </Switch>
    </>
  );
};

export default NavigationBar;
