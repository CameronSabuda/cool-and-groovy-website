import React from 'react'
import { Container, Form, Button } from 'react-bootstrap'

const SignUp = () => {
	return (
		<div className="bg-dark-alt py-5 my-5">
			<Container>
				<Form className="bg-dark-alt py-5 my-5 text-white">
					<Form.Group controlId='form.Name'>
						<Form.Label>Name</Form.Label>
						<Form.Control type='text' placeholder='Enter name' />
					</Form.Group>
					<Form.Group controlId='form.Email'>
						<Form.Label>Email address</Form.Label>
						<Form.Control type='email' placeholder='name@example.com' />
					</Form.Group>
					<Form.Group controlId='form.Textarea'>
						<Form.Label>Comment</Form.Label>
						<Form.Control as='textarea' rows={3} />
					</Form.Group>
						<Button variant="warning" className="my-5">Submit</Button>
				</Form>
			</Container>
		</div>
	)
}

export default SignUp
