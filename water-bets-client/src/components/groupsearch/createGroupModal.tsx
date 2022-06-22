import React, { useState } from "react";
import { LoggedInNavbar } from "../navbar/loggedInNavbar";
import Container from "react-bootstrap/Container";
import classNames from "classnames/bind";
import { Modal, Form, Button, Col, Row } from "react-bootstrap";

export interface CreateGroupModalProps {
  show: boolean;
  setShow: (x: boolean) => void;
}

export const CreateGroupModal: React.FC<CreateGroupModalProps> = (
  props: CreateGroupModalProps
) => {
  const [passwordRequired, setPasswordRequired] = useState<boolean>(true);

  const handleClose = () => props.setShow(false);
  const handleShow = () => props.setShow(true);

  const handleSubmit = (e: any) => {
    e.preventDefault();
    handleClose();
  };

  const passwordInput = (): JSX.Element | null => {
    if (passwordRequired) {
      return (
        <Form.Control type="text" placeholder="Password" autoFocus required />
      );
    }
    return null;
  };

  return (
    <Modal show={props.show} onHide={handleShow}>
      <Form onSubmit={handleSubmit}>
        <Modal.Header closeButton>
          <Modal.Title>Create New Group</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
            <Form.Label>Group Name</Form.Label>
            <Form.Control type="text" placeholder="groupname" autoFocus />
          </Form.Group>
          <Row>
            <Col md="6">
              <Form.Group className="mb-3" id="formGridCheckbox">
                <Form.Check
                  type="checkbox"
                  checked={passwordRequired}
                  onChange={e => setPasswordRequired(!passwordRequired)}
                  label="Require Password?"
                />
              </Form.Group>
            </Col>
            <Col md="6">{passwordInput()}</Col>
          </Row>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cancel
          </Button>
          <Button type="submit" variant="primary">
            Create
          </Button>
        </Modal.Footer>
      </Form>
    </Modal>
  );
};
