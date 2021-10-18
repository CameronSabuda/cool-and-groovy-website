import React from "react";
import { Container, Row, Col, Image } from "react-bootstrap";

function Test() {
	return (
		<div className='bg-light py-5'>
			<Container fluid className='bg-light-alt py-5 my-5'>
				<Row>
					<Col
						lg={3}
						md={6}
						sm={12}
						className='border border-primary h-100'>
						1st column
						<Image src='https://picsum.photos/300' />
					</Col>
					<Col
						lg={3}
						md={6}
						sm={12}
						className='border border-primary h-100'>
						2nd Column
					</Col>
					<Col
						lg={3}
						md={6}
						sm={12}
						className='border border-primary h-100'>
						3rd Column
					</Col>
					<Col
						lg={3}
						md={6}
						sm={12}
						className='border border-primary h-100'>
						3rd Column
					</Col>
				</Row>
				<Row></Row>
			</Container>
		</div>
	);
}

export default Test;
