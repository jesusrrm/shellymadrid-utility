import React, { useState, useEffect } from 'react';

const ContactInfo: React.FC = () => {
    const [contactContent, setContactContent] = useState<string>('');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('https://shellymadrid.com/pages/contact');
                if (!response.ok) {
                    throw new Error('Failed to fetch contact information');
                }
                const data = await response.text();
                setContactContent(data);
            } catch (error) {
                console.error('Error fetching contact information:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            
            <div dangerouslySetInnerHTML={{ __html: contactContent }} />
        </div>
    );
};

export default ContactInfo;
