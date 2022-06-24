import React from "react";
import {
  Table,
  DropdownButton,
  ButtonGroup,
  Dropdown,
  Row,
  Col
} from "react-bootstrap";

export interface OffersReceivedProps {}

export const OffersReceived: React.FC<OffersReceivedProps> = (
  props: OffersReceivedProps
) => {
  return (
    <>
      <Row className="mt-5 offer-group">
        <Col>
          <h4>Not Arizona State</h4>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>From</th>
                <th>Water Bet</th>
                <th>My Cost</th>
                <th>To Win</th>
                <th>Expires</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Brendan Borman</td>
                <td>
                  I believe that Nico Collins will only have 15tds this year
                </td>
                <td>20</td>
                <td>10</td>
                <td>14 Days</td>
                <td>
                  <DropdownButton
                    as={ButtonGroup}
                    variant="link"
                    title="Reply"
                    id="bg-vertical-dropdown-1"
                  >
                    <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
                  </DropdownButton>
                </td>
              </tr>
              <tr>
                <td>Erik Meyer</td>
                <td>
                  I believe that Watson will play at least 8 games this season
                </td>
                <td>50</td>
                <td>65</td>
                <td>5 Days</td>
                <td>
                  <DropdownButton
                    as={ButtonGroup}
                    variant="link"
                    title="Reply"
                    id="bg-vertical-dropdown-1"
                  >
                    <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
                  </DropdownButton>
                </td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
      <Row className="mt-5 offer-group">
        <Col>
          <h4>Piano Man</h4>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>From</th>
                <th>Water Bet</th>
                <th>My Cost</th>
                <th>To Win</th>
                <th>Expires</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Brent Theonen</td>
                <td>I believe that there will be a hotfix this next release</td>
                <td>10</td>
                <td>10</td>
                <td>3 Days</td>
                <td>
                  <DropdownButton
                    as={ButtonGroup}
                    variant="link"
                    title="Reply"
                    id="bg-vertical-dropdown-1"
                  >
                    <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
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
