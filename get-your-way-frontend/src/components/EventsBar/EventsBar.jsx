import React, { useEffect, useState } from "react";
import EventsTile from './EventsTile/EventsTile';
import axios from 'axios';
import { CardGroup } from "react-bootstrap";


const client = axios.create({
    baseURL: "http://99.81.186.138:9090/events?latitude=51.5074&longitude=-0.1278"
})

const EventsBar = () => {
    const [events, setEvents] = useState(null)

    useEffect(() => {
        const getEvents =  async () => {
            let response = await client.get()
            let {responseData} = response.data
            setEvents(responseData)
        }
        getEvents()
    }, [])


    return (
        <div className= 'EventsBar bg-secondary'>
            <CardGroup className='d-flex flex-row'>
                {events && events.map((event, i) => {
                    return <EventsTile data={event} key={i}/>
                })}
            </CardGroup>
        </div>
    )
}

export default EventsBar;
