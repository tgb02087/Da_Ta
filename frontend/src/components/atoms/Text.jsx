/**
 * @author mingyu
 * @description 여기에 텍스트, 라벨과 관련된 스타일 컴포넌트를 작성합니다.
 */
import styled from "styled-components";

export const MainText = styled.p`
  display: flex;
  font-size: 1.5rem;
  color: white;
  width: 100%;
  text-align: center;
  align-items: center;
  justify-content: center;
  margin: ${(props) => props.margin};
  font-weight: ${(props) => props.fontWeight};
`;

export const FooterText = styled.p`
  display: flex;
  font-size: 0.5rem;
  color: white;
  width: 100%;
  text-align: center;
  align-items: center;
  justify-content: center;
  margin: ${(props) => props.margin};
  font-weight: ${(props) => props.fontWeight};
`;


MainText.defaultProps = {
  fontWeight: "500",
};

FooterText.defaultProps = {
  fontWeight: "100",
};