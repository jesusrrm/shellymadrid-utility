import React from 'react';
import { Container, Nav, Navbar, NavDropdown } from 'react-bootstrap';

interface MenuItem {
  name: string;
  path: string;
  children?: MenuItem[];
}

interface NavigationBarProps {
  menuItems: MenuItem[];
}

const NavigationBar: React.FC<NavigationBarProps> = ({ menuItems }) => {
  const renderMenuItems = (items: MenuItem[]) => {
    return items.map((item) => {
      if (item.children && item.children.length > 0) {
        return (
          <NavDropdown title={item.name} id={`nav-dropdown-${item.name}`} key={item.name}>
            {item.children.map((subItem) => (
              <NavDropdown.Item href={subItem.path} key={subItem.name}>
                {subItem.name}
              </NavDropdown.Item>
            ))}
          </NavDropdown>
        );
      } else {
        return (
          <Nav.Link href={item.path} key={item.name}>
            {item.name}
          </Nav.Link>
        );
      }
    });
  };

  return (
    <Navbar collapseOnSelect expand="lg" className="bg-body-tertiary" variant="light">
      <Container>
        <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">{renderMenuItems(menuItems)}</Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
