package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class MarketDataRequestMessage(mDReqIDField:MDReqIDField,
                                    subscriptionRequestTypeField:SubscriptionRequestTypeField,
                                    marketDepthField:MarketDepthField,
                                    mDUpdateTypeField:Option[MDUpdateTypeField]=None,
                                    aggregatedBookField:Option[AggregatedBookField]=None,
                                    noMDEntryTypesField:NoMDEntryTypesField,
                                    mDEntryTypesGroups: List[MDEntryTypesGroup],
                                    noRelatedSymField:NoRelatedSymField,
                                    relatedSymGroups: List[RelatedSymGroup]) extends SfFixMessageBody("V")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDEntryTypesField.value != mDEntryTypesGroups.size)
    throw SfRepeatingGroupCountException(NoMDEntryTypesField.TagId,noMDEntryTypesField.value, mDEntryTypesGroups.size)
  if (noRelatedSymField.value != relatedSymGroups.size)
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.value, relatedSymGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDReqIDField)
    fmt(b,subscriptionRequestTypeField)
    fmt(b,marketDepthField)
    mDUpdateTypeField.foreach(fmt(b,_))
    aggregatedBookField.foreach(fmt(b,_))
    fmt(b,noMDEntryTypesField)
    fmt(b,noRelatedSymField)
    b
  }

}
     
object MarketDataRequestMessage extends SfFixMessageDecoder {
  val MsgType="V"
  val MsgName="MarketDataRequest"
             
  override val MandatoryFields = HashSet[Int](
    MDReqIDField.TagId, SubscriptionRequestTypeField.TagId, MarketDepthField.TagId, NoMDEntryTypesField.TagId, NoRelatedSymField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDEntryTypesGroup.isMandatoryField(tagId) || RelatedSymGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDUpdateTypeField.TagId, AggregatedBookField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDEntryTypesGroup.isOptionalField(tagId) || RelatedSymGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDEntryTypesGroup.isFieldOf(tagId) || RelatedSymGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDEntryTypesField.TagId, NoRelatedSymField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataRequestMessage(MDReqIDField.decode(myFields.get(MDReqIDField.TagId)).get,
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get,
        MarketDepthField.decode(myFields.get(MarketDepthField.TagId)).get,
        myFields.get(MDUpdateTypeField.TagId).flatMap(f=>MDUpdateTypeField.decode(f)),
        myFields.get(AggregatedBookField.TagId).flatMap(f=>AggregatedBookField.decode(f)),
        NoMDEntryTypesField.decode(myFields.get(NoMDEntryTypesField.TagId)).get,
        if (nextTagPosLookup.contains(NoMDEntryTypesField.TagId)) MDEntryTypesGroup.decode(flds, nextTagPosLookup(NoMDEntryTypesField.TagId)).get else List.empty,
        NoRelatedSymField.decode(myFields.get(NoRelatedSymField.TagId)).get,
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)).get else List.empty))
    } else None
  }

    
}
     