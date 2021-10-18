import React from "react";
import "./NavigationBar.css";
import { Navbar, Nav, Container, Button, Image } from "react-bootstrap";
import { Switch, Route, Link } from "react-router-dom";
import logo from "../../logo.svg";
// import LandingPage from "components/LandingPage/index.js"

const NavigationBar = () => {
  return (
    <>
      <Container>
        <Navbar bg="light" variant="light" expand="md">
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
              <Nav.Link as={Link} to="/signup">
                Signup
              </Nav.Link>
              <Button variant="primary" size="md" as={Link} to="/calltoaction">
                Call to action
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
