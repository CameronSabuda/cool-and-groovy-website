import EventsTile from './EventsTile/EventsTile';
import React from 'react';



const EventsBar = () => {
    return (
        <div className= 'EventsBar d-flex bg-secondary'>
            {[...Array(5)].map(event => {
                return <EventsTile />
            })}
            
        </div>
    )
}

export default EventsBar;
