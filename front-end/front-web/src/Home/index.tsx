
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import {ReactComponent as ImgBody}  from './Elotech_Faxada.svg';



function Home() {
    return (

        <>
            <div className="container">
                <Navbar bg="light" expand="lg">
                    <Navbar.Brand href="#home">Elotech</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <NavDropdown title="Menu" id="basic-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">Cadastrar Pessoa Física</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.2">Cadastrar Contato</NavDropdown.Item>
                                <NavDropdown.Divider />
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                <div>
                    <ImgBody/>
                </div>
            </div>
        </>
    );
}

export default Home;