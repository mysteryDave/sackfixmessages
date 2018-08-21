package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class TradingSessionListRequestMessage(tradSesReqIDField:TradSesReqIDField,
                                            marketIDField:Option[MarketIDField]=None,
                                            marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                            tradingSessionIDField:Option[TradingSessionIDField]=None,
                                            tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                            securityExchangeField:Option[SecurityExchangeField]=None,
                                            tradSesMethodField:Option[TradSesMethodField]=None,
                                            tradSesModeField:Option[TradSesModeField]=None,
                                            subscriptionRequestTypeField:SubscriptionRequestTypeField) extends SfFixMessageBody("BI")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradSesReqIDField)
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    tradSesMethodField.foreach(fmt(b,_))
    tradSesModeField.foreach(fmt(b,_))
    fmt(b,subscriptionRequestTypeField)
    b
  }

}
     
object TradingSessionListRequestMessage extends SfFixMessageDecoder {
  val MsgType="BI"
  val MsgName="TradingSessionListRequest"
             
  override val MandatoryFields = HashSet[Int](
    TradSesReqIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    MarketIDField.TagId, MarketSegmentIDField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SecurityExchangeField.TagId, 
    TradSesMethodField.TagId, TradSesModeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradSesReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradingSessionListRequestMessage(TradSesReqIDField.decode(myFields.get(TradSesReqIDField.TagId)).get,
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(TradSesMethodField.TagId).flatMap(f=>TradSesMethodField.decode(f)),
        myFields.get(TradSesModeField.TagId).flatMap(f=>TradSesModeField.decode(f)),
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get))
    } else None
  }

    
}
     