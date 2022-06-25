import React from "react";
import {
  Table,
  DropdownButton,
  ButtonGroup,
  Dropdown,
  Row,
  Col
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMailForward } from "@fortawesome/free-solid-svg-icons";

export interface OffersSentProps {}

export const OffersSent: React.FC<OffersSentProps> = (
  props: OffersSentProps
) => {
  return (
    <>
      <Row className="mt-5 offer-group">
        <Col>
          <h4>Not Arizona State</h4>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>
                  <FontAwesomeIcon icon={faMailForward} /> To
                </th>
                <th>Water Bet</th>
                <th>My Cost</th>
                <th>To Accept</th>
                <th>Expires</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Brendan Borman</td>
                <td>
                  I believe that Nico Collins will have no more than 4 tds this
                  year
                </td>
                <td>20</td>
                <td>10</td>
                <td>14 Days</td>
                <td>
                  <DropdownButton
                    as={ButtonGroup}
                    variant="link"
                    title="Actions"
                    id=""
                  >
                    <Dropdown.Item eventKey="1">Revoke Offer</Dropdown.Item>
                  </DropdownButton>
                </td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
    </>
  );
};