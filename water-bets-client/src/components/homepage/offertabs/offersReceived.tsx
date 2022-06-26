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
import { faMailBulk } from "@fortawesome/free-solid-svg-icons";

export interface OffersReceivedProps {}

export const OffersReceived: React.FC<OffersReceivedProps> = (
  props: OffersReceivedProps
) => {
  return (
    <>
      <Row className="mt-5 offer-group">
        <Col>
          <h4>Not Arizona State</h4>
          <Table bordered hover>
            <thead>
              <tr>
                <th>
                  <FontAwesomeIcon icon={faMailBulk} /> From
                </th>
                <th>Water Bet</th>
                <th>Cost to Accept</th>
                <th>To Win</th>
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
                    title="Reply"
                    id=""
                  >
                    <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">
                      Deline With Comment
                    </Dropdown.Item>
                  </DropdownButton>
                </td>
              </tr>
              <tr>
                <td>Curtis Dingdong</td>
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
                    <Dropdown.Item eventKey="2">
                      Deline With Comment
                    </Dropdown.Item>
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
          <Table bordered hover>
            <thead>
              <tr>
                <th>
                  <FontAwesomeIcon icon={faMailBulk} /> From
                </th>
                <th>Water Bet</th>
                <th>Cost to Accept</th>
                <th>To Win</th>
                <th>Expires</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Allen Peterson</td>
                <td>
                  I believe I get 10+ kills in our 1 v 1 match next time we play
                </td>
                <td>10</td>
                <td>10</td>
                <td>3 Days</td>
                <td>
                  <DropdownButton
                    as={ButtonGroup}
                    variant="link"
                    title="Reply"
                    id=""
                  >
                    <Dropdown.Item eventKey="1">Accept Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Deline Offer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">
                      Deline With Comment
                    </Dropdown.Item>
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
