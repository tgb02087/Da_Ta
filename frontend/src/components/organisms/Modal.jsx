/**
 * @author mingyu
 */

import { faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from "react";
import styled from "styled-components";
import { media } from "../../utils/styleUtil";
import Title from "../atoms/Title";
import TranslucentBackground from "./../atoms/TranslucentBackground";
import { useEffect } from "react";

const Modal = ({
  children,
  modalToggle,
  setModalToggle,
  onModalClick,
  titleText,
  height,
  width,
  maxWidth,
}) => {
  useEffect(() => {
    document.body.style.cssText = `
      position: absolute; 
      top: -${window.scrollY}px;
			overflow: hidden;
      width: 100%;`;
    return () => {
      const scrollY = document.body.style.top;
      document.body.style.cssText = "overflow: overlay;";
      window.scrollTo(0, parseInt(scrollY || "0", 10) * -1);
    };
  }, []);

  return (
    <>
      {modalToggle && (
        <>
          <TranslucentBackground onClick={() => setModalToggle(false)} />
          <ModalContainer height={height} width={width} maxWidth={maxWidth}>
            {/* 닫기 버튼 */}
            <FaWrapper onClick={() => setModalToggle(false)}>
              <FontAwesomeIcon icon={faX} size="lg" />
            </FaWrapper>
            {/* 모달 제목 */}
            <Title fontSize="2rem" fontWeight="bold" color="black">
              {titleText}
            </Title>
            {/* 모달 Content */}
            <ContentArea>{children}</ContentArea>
          </ModalContainer>
        </>
      )}
    </>
  );
};

const ModalContainer = styled.div`
  display: flex;
  position: absolute;
  flex-direction: column;
  z-index: 1001;
  width: ${(props) => props.width || "55rem"};
  height: ${(props) => props.height || "80vh"};
  max-width: ${(props) => props.maxWidth || ""};
  border-radius: 1rem;
  background-color: white;
  align-items: center;
  box-sizing: border-box;
  padding: 1.5rem;

  ${media.tablet1`
    width: 90vw;
  `};
  ${media.phone`
    width: 90vw;
  `};
`;

const FaWrapper = styled.div`
  display: flex;
  position: absolute;
  padding: 1rem;
  right: 1rem;
  top: 1rem;
  align-items: center;
  justify-content: center;
  pointer: cursor;
`;

const ContentArea = styled.div`
  display: flex;
  margin: 1.5rem 0 0 0;
  width: 100%;
  height: 85%;
  box-sizing: border-box;
  overflow: hidden;
`;
export default Modal;
