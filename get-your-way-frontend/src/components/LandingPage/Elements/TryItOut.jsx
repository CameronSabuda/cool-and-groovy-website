import React from 'react'
import { Container, Row, Col, Image } from 'react-bootstrap'

const styles = {
	maxHeight: '30%',
	maxWidth: '75%',
}

const TryItOut = () => {
	return (
		<div className='bg-light py-5'>
			<Container>
				<Row>
					<h1>Movies to try out</h1>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur, sit. Rem, tenetur quis. Illum
						repellat veniam nihil, itaque reiciendis praesentium ducimus aut, maxime velit debitis unde
						sapiente. Eligendi, alias natus?
					</p>
				</Row>
				<Row className='d-flex align-items-center justify-content-center gy-3'>
					<Col md={4} sm={12} style={styles}>
						<Image src='https://picsum.photos/600/800' rounded fluid />
					</Col>
					<Col md={4} sm={12} style={styles}>
						<Image src='https://picsum.photos/600/800' rounded fluid />
					</Col>
					<Col md={4} sm={12} style={styles}>
						<Image src='https://picsum.photos/600/800' rounded fluid />
					</Col>
				</Row>
			</Container>
		</div>
	)
}

export default TryItOut
